<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %>
<div>
  <span class="text-2xl">Configuración de Prestamos</span>

  <div class="flex justify-center items-center">
    <form class="space-y-4 w-1/3">
      <div class="flex flex-col">
        <label class="text-xl font-medium" for="userIdInput">Usuario ID:</label>
        <div class="flex w-full justify-center items-center">
          <input
            class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
            type="text"
            id="userIdInput"
            name="userId"
            required
          />
          <div id="isOkUserId" class="hiddenElement">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="30"
              height="30"
              fill="currentColor"
              class="bi bi-check"
              viewBox="0 0 16 16"
            >
              <path
                class="text-green-700"
                d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z"
              />
            </svg>
          </div>
        </div>
        <span id="errorUserId"></span>
      </div>

      <div class="flex flex-col">
        <label class="text-xl font-medium" for="materialIdInput"
          >Material ID:</label
        >
        <div class="flex w-full justify-center items-center">
          <input
            class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
            type="text"
            id="materialIdInput"
            name="materialId"
            required
          />
          <div id="isOkMaterialId" class="hiddenElement">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="30"
              height="30"
              fill="currentColor"
              class="bi bi-check"
              viewBox="0 0 16 16"
            >
              <path
                class="text-green-700"
                d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425z"
              />
            </svg>
          </div>
        </div>
        <span id="errorMaterialId"></span>
      </div>

      <div>
        <label class="text-xl font-medium" for="loanConfig"
          >Tipo de Usuario:</label
        >
        <select
          class="rounded-sm border-2 border-gray-400 py-2 focus:border-blue-500 focus:outline-none w-full"
          id="loanConfig"
          name="loanConfig"
          required
          disabled
        ></select>
      </div>

      <button
        type="submit"
        class="mt-4 px-4 py-2 bg-blue-500 text-white rounded-sm hover:bg-blue-600"
      >
        Guardar
      </button>
    </form>
  </div>
</div>

<script>
  let userInputValid = false;
  let materialInputValid = false;

  const userIdInput = document.getElementById("userIdInput");
  const userIdErrorFeedBack = document.getElementById("errorUserId");

  userIdInput.addEventListener("focusout", () => {
    fetch(`${contextPath}/admin/user-id?userId=\${userIdInput.value}`, {
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(async (res) => {
        if (res.ok) {
          document
            .getElementById("isOkUserId")
            .classList.remove("hiddenElement");
          userInputValid = true;
          userIdErrorFeedBack.textContent = "";
        }else{
            userInputValid = false;
             document
            .getElementById("isOkUserId")
            .classList.add("hiddenElement");

          document.getElementById("loanConfig").addAttribute("disabled")
          const result =await res.json();
             userIdErrorFeedBack.textContent = result.message;
        }
      }).catch(()=>{
        userInputValid = false;
        userIdErrorFeedBack.textContent = "Valor no valido."

      document.getElementById("loanConfig").setAttribute("disabled")
    })

  });

  const materialIdInput = document.getElementById("materialIdInput");
  const materialErrorFeedback = document.getElementById("errorMaterialId");

  materialIdInput.addEventListener("focusout", () => {
   fetch(`${contextPath}/admin/material-id?materialId=\${materialIdInput.value}`, {
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then(async (res) => {
        if (res.ok) {
          document
            .getElementById("isOkMaterialId")
            .classList.remove("hiddenElement");
          materialInputValid = true;

          materialErrorFeedback.textContent = '';
          if(userInputValid && materialInputValid){
           document.getElementById("loanConfig").removeAttribute("disabled")
          }


        }else{
            materialInputValid = false;

          document.getElementById("loanConfig").setAttribute("disabled")
             document
            .getElementById("isOkMaterialId")
            .classList.add("hiddenElement");

          const result =await res.json();
          materialErrorFeedback.textContent = result.message;
        }
      }).catch(()=>{
     materialInputValid = false;
     materialErrorFeedback.textContent = "Valor no valido."

     document.getElementById("loanConfig").setAttribute("disabled")
   })

  });
</script>
