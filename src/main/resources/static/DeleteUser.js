let formDelete = document.forms["formDeleteUser"];
deleteUser();

async function deleteModalData(id) {
    const modal = new bootstrap.Modal(document.querySelector('#deleteModal'));
    await theModal(formDelete, modal, id);
    switch (formDelete.roles.value) {
        case '1':
            formDelete.roles.value = 'ADMIN';
            break;
        case '2':
            formDelete.roles.value = 'USER';
            break;
    }
}

function deleteUser() {
    formDelete .addEventListener("submit", ev => {
        ev.preventDefault();
        fetch("http://localhost:8080/admin/" + formDelete .id.value, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            $('#deleteFormCloseButton').click();
            tableOfAllUsers();
        });
    });
}