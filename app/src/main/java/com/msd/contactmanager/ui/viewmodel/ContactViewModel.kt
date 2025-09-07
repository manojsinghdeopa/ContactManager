package com.msd.contactmanager.ui.viewmodel

// ViewModel for managing contact data
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msd.contactmanager.data.model.Contact
import com.msd.contactmanager.data.repository.ContactRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel() {

    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts: StateFlow<List<Contact>> = _contacts.asStateFlow()

    init {
        fetchContacts()
    }

    private fun fetchContacts() {
        viewModelScope.launch {
            repository.getAllContacts().collect { contactList ->
                _contacts.value = contactList
            }
        }
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch {
            repository.insertContact(contact)
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            repository.updateContact(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            repository.deleteContact(contact)
        }
    }

    suspend fun getContactById(id: String): Contact? {
        return repository.getContactById(id)
    }
}

