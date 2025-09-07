package com.msd.contactmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.msd.contactmanager.data.database.ContactDatabase
import com.msd.contactmanager.data.repository.ContactRepository
import com.msd.contactmanager.ui.screens.ContactListScreen
import com.msd.contactmanager.ui.theme.ContactManagerTheme
import com.msd.contactmanager.ui.viewmodel.ContactViewModel
import com.msd.contactmanager.ui.viewmodel.ContactViewModelFactory
import kotlin.getValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Instantiate database, DAO, repository, and ViewModel factory
        val database = ContactDatabase.getDatabase(applicationContext)
        val contactDao = database.contactDao()
        val repository = ContactRepository(contactDao)
        val factory = ContactViewModelFactory(repository)
        val contactViewModel: ContactViewModel by viewModels { factory }

        // Set the content view using Jetpack Compose
        setContent {
            ContactManagerTheme {
                ContactListScreen(
                    contacts = contactViewModel.contacts.collectAsState().value,
                    onAddContact = { contact -> contactViewModel.addContact(contact) },
                    onContactClick = { contact -> /* handle contact click, e.g., show details */ }
                )
            }
        }

    }
}
