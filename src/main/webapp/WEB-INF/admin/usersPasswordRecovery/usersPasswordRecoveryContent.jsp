<%--
  Created by IntelliJ IDEA.
  User: bunny
  Date: 4/12/2024
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div>
    <span class="text-2xl">Actualizar Contraseñas</span>
   <div class="flex justify-center">
       <form class="flex justify-center items-center space-x-4 w-1/3">
            <label class="text-xl font-medium" for="username">Username:</label>
            <input
                    class="rounded-sm border-2 border-gray-400  py-2 focus:border-blue-500 focus:outline-none w-full"
                    type="text"
                    id="username"
                    name="username"
                    required
            />


           <button
                class="bg-blue-700 text-white font-medium py-2 px-2 w-full rounded-sm hover:bg-blue-600"
                type="submit"
        >
           <span>BUSCAR</span>
        </button>
    </form>
   </div>
    <div class="mt-4 flex justify-center">
        <table class="table-auto border-collapse border border-gray-400 w-2/3">
            <thead>
                <tr>
                    <th class="border border-gray-400 px-4 py-2">ID</th>
                    <th class="border border-gray-400 px-4 py-2">Nombre de Usuario</th>
                    <th class="border border-gray-400 px-4 py-2">Rol</th>
                    <th class="border border-gray-400 px-4 py-2">Acción</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr class="hover:bg-gray-100">
                        <td class="border border-gray-400 text-xl px-4 py-2">${user.getId()}</td>
                        <td class="border border-gray-400 text-xl px-4 py-2">${user.getUsername()}</td>
                        <td class="border border-gray-400 text-xl px-4 py-2">${user.getRole()}</td>
                        <td class="border border-gray-400 text-xl px-4 py-2">
                                <input type="hidden" name="userId" value="${user.id}">
                                <button
                                    class="bg-green-700 text-white font-medium p-2 rounded-sm hover:bg-blue-600"
                                    onclick="openPasswordModal(${user.id})"
                                >
                                    Actualizar Contraseña
                                </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="4" class="border border-gray-400 px-4 py-2 text-center">
                    <div class="flex justify-between items-center text-black">
                        <button
                            class="bg-gray-700 text-white font-medium py-1 px-4 rounded-sm hover:bg-gray-600"
                            onclick="navigatePage(${page- 1})"
                            <c:if test="${page== 1}" >disabled</c:if>
                        >
                            Anterior
                        </button>
                        <span class="text-lg font-medium">
                            Página ${page} de ${totalPages}
                        </span>
                        <button
                            class="bg-gray-700 text-white font-medium py-1 px-4 rounded-sm hover:bg-gray-600"
                            onclick="navigatePage(${page+ 1})"
                            <c:if test="${page == totalPages || totalPages == 0}" >disabled</c:if>
                        >
                            Siguiente
                        </button>
                    </div>
                </td>
            </tr>
        </tfoot>
        </table>
    </div>
</div>
 <script>
        // Función para abrir el formulario con SweetAlert
        function openPasswordModal(userId) {
            Swal.fire({
                title: 'Actualizar Contraseña',
                html: `
                    <form id="updatePasswordForm" method="post" action="updatePassword">
                        <input id="newPassword" name="newPassword" type="password" required
                               class="swal2-input" placeholder="Ingresa la nueva contraseña">
                        <input id="confirmPassword" name="confirmPassword" type="password" required
                               class="swal2-input" placeholder="Confirma la contraseña">
                    </form>
                `,
                showCancelButton: true,
                confirmButtonText: 'Actualizar',
                cancelButtonText: 'Cancelar',
                focusConfirm: false,
                preConfirm: () => {
                    const newPassword = Swal.getPopup().querySelector('#newPassword').value;
                    const confirmPassword = Swal.getPopup().querySelector('#confirmPassword').value;

                    if (!newPassword || !confirmPassword) {
                        Swal.showValidationMessage('Ambos campos son obligatorios');
                        return false;
                    }

                    if (newPassword !== confirmPassword) {
                        Swal.showValidationMessage('Las contraseñas no coinciden');
                        return false;
                    }

                    fetch("${contextPath}/admin/password-recovery",{method:'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                            userId,
                            newPassword
                        })
                    }).then(r =>{
                        if(r.ok){
                            Swal.fire({
                                  title: "Contraseña actualizada con exito.",
                                  icon: "success",
                                timer:2000
                                });
                        }else{
                            Swal.fire({
                                  title: "Intentelo nuevamente.",
                                  icon: "warning",
                                timer:2000
                                });
                        }
                    });

                }
            });
        }

        function navigatePage(pageNumber) {
            const url = `${contextPath}/admin/password-recovery?page=`+pageNumber;
            window.location.href = url;
        }
    </script>