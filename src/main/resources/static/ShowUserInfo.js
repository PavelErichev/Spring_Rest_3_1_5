fillInPrincipal();

function fillInPrincipal() {
    fetch("http://localhost:8080/user/userList")
        .then(res => res.json())
        .then(user => {
            console.log('userSata', JSON.stringify(user))
            $('#headerUserName').append(user.email);
            $('#headerRole').append(user.shortRole);
            let userList = `$(
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>   
                    <td>${user.email}</td>
                    <td>${user.shortRole}</td>
                </tr>)`;
            $('#userTable').append(userList);
        })
}