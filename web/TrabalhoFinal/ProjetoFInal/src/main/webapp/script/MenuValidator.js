function validateMenuItem() {
    let name = frmNovoPrato.name.value;
    let ingredients = frmNovoPrato.ingredients.value;
    let type = frmNovoPrato.type.value;

    if (name === "") {
        alert("Preencha o campo Nome");
        frmNovoPrato.name.focus();
        return false;
    } else if (ingredients === "") {
        alert("Preencha o campo Ingredientes");
        frmNovoPrato.ingredients.focus();
        return false;
    } else if (type === "") {
        alert("Preencha o campo Tipo");
        frmNovoPrato.type.focus();
        return false;
    }

    return true;
}

function redirectToHome() {
       window.location.href = 'villaHome.jsp';
}

function confirmDelete(event) {
            var userConfirmed = confirm("Tem certeza que deseja excluir?");
            
            if (!userConfirmed) {
                alert("Exclusão cancelada.");
                event.preventDefault(); 
            }

            return userConfirmed;
 }
 