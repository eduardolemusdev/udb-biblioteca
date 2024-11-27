
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/webapp/**/*.jsp", // Escanea todas las vistas JSP
    "./src/main/webapp/**/*.html", // Escanea archivos HTML estáticos (opcional)
    "./src/main/webapp/js/**/*.js" // Escanea scripts JS que puedan usar clases de Tailwind
  ],
  theme: {
    extend: {}, // Aquí puedes personalizar tu tema
  },
  plugins: [],
}
