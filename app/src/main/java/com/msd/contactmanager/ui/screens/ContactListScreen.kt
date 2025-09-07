package com.msd.contactmanager.ui.screens

// (screen for displaying contact list)

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.msd.contactmanager.R
import com.msd.contactmanager.data.model.Contact
import com.msd.contactmanager.ui.components.AddContactForm
import com.msd.contactmanager.ui.components.ContactItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(
    contacts: List<Contact>,
    onAddContact: (Contact) -> Unit,
    onContactClick: (Contact) -> Unit) {


    val isAddingContact = remember { mutableStateOf(false) }
    val nameState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact Manager") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer, titleContentColor = Color.White)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { isAddingContact.value = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add Contact"
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            if (isAddingContact.value) {
                AddContactForm(
                    nameState = nameState,
                    phoneState = phoneState,
                    emailState = emailState,
                    onAddContact = { contact ->
                        onAddContact(contact)
                        isAddingContact.value = false
                    }
                )
            } else {
                if (contacts.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No contacts available. Click + to add.", style = MaterialTheme.typography.bodyMedium)
                    }
                } else {
                    LazyColumn {
                        items(contacts) { contact ->
                            ContactItem(contact = contact, onClick = { onContactClick(contact) })
                        }
                    }
                }
            }
        }
    }
}