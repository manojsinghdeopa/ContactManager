package com.msd.contactmanager.data.repository

// Implement repository class for data operations
import com.msd.contactmanager.data.dao.ContactDao
import com.msd.contactmanager.data.model.Contact
import kotlinx.coroutines.flow.Flow


class ContactRepository(private val contactDao: ContactDao) {

    fun getAllContacts(): Flow<List<Contact>> = contactDao.getAllContacts()

    suspend fun getContactById(id: String): Contact? = contactDao.getContactById(id)

    suspend fun insertContact(contact: Contact) = contactDao.insertContact(contact)

    suspend fun updateContact(contact: Contact) = contactDao.updateContact(contact)

    suspend fun deleteContact(contact: Contact) = contactDao.deleteContact(contact)
}