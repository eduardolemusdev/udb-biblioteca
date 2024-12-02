const materialTypeComboBox = document.getElementById("materialTypeComboBox");

materialTypeComboBox.addEventListener("change", (e) => {
  const materialType = e.target.value;
  const dynamicFields = document.getElementById("dynamicFields");

  let fields = "";
  switch (materialType) {


    case "book":
      fields = `
        <label class="text-xl font-medium" for="title">Título:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="title" name="title" />
        
        <label class="text-xl font-medium" for="author">Autor:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="author" name="author" required />
        
        <label class="text-xl font-medium" for="isbn">ISBN:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="isbn" name="isbn" />
        
        <label class="text-xl font-medium" for="publication_year">Año de Publicación:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="publication_year" name="publication_year" />
        
        <label class="text-xl font-medium" for="edition">Edición:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="edition" name="edition" />
        
        <label class="text-xl font-medium" for="publisher">Editorial:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="publisher" name="publisher" />
        
        <label class="text-xl font-medium" for="pages">Páginas:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="pages" name="pages" />
    `;
      break;

    case "thesis":
      fields = `
        <label class="text-xl font-medium" for="title">Título:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="title" name="title" />
        
        <label class="text-xl font-medium" for="author">Autor:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="author" name="author" required />
        
        <label class="text-xl font-medium" for="advisor">Asesor:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="advisor" name="advisor" />
        
        <label class="text-xl font-medium" for="degree">Grado:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="degree" name="degree" />
        
        <label class="text-xl font-medium" for="university">Universidad:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="university" name="university" />
        
        <label class="text-xl font-medium" for="year">Año:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="year" name="year" />
        
        <label class="text-xl font-medium" for="department">Departamento:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="department" name="department" />
        
        <label class="text-xl font-medium" for="abstract">Resumen:</label>
        <textarea class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" id="abstract" name="abstract"></textarea>
        
        <label class="text-xl font-medium" for="keywords">Palabras Clave:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="keywords" name="keywords" />
        
        <label class="text-xl font-medium" for="pages">Páginas:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="pages" name="pages" />
    `;
      break;

    case "cd":
      fields = `
        <label class="text-xl font-medium" for="title">Título:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="title" name="title" />
        
        <label class="text-xl font-medium" for="artist">Artista:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="artist" name="artist" />
        
        <label class="text-xl font-medium" for="genre">Género:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="genre" name="genre" />
        
        <label class="text-xl font-medium" for="release_year">Año de Lanzamiento:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="release_year" name="release_year" />
        
        <label class="text-xl font-medium" for="label">Discográfica:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="label" name="label" />
        
        <label class="text-xl font-medium" for="track_count">Número de Pistas:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="track_count" name="track_count" />
        
        <label class="text-xl font-medium" for="format">Formato:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="format" name="format" />
    `;
      break;

    case "dvd":
      fields = `
        <label class="text-xl font-medium" for="title">Título:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="title" name="title" />
        
        <label class="text-xl font-medium" for="director">Director:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="director" name="director" />
        
        <label class="text-xl font-medium" for="genre">Género:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="text" id="genre" name="genre" />
        
        <label class="text-xl font-medium" for="release_year">Año de Lanzamiento:</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="release_year" name="release_year" />
        
        <label class="text-xl font-medium" for="duration">Duración (minutos):</label>
        <input class="rounded-sm border-2 border-gray-400 focus:border-blue-500 focus:outline-none" type="number" id="duration" name="duration" />
    `;
      break;

    default:
     fields = "<span class='text-xl'>Selecciona una opción.</span>"
      break;

  }
  dynamicFields.innerHTML = fields;
});
