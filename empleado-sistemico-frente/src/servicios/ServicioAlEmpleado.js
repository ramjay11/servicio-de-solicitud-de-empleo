import axios from "axios";

const API_URL = "http://localhost:8083/api/v1/empleados";

export default {
  conseguirEmpleados() { 
    return axios.get(API_URL);
 },

 obtenerEmpleadosPorIdentificacion(id) {
    return axios.get(`${API_URL}/${id}`);
 },

 agregarEmpleado(empleado) {
    return axios.post(`${API_URL}/agregar`, empleado);
 },

 actualizarEmpleado(empleado) {
    return axios.put(`${API_URL}/actualizar`, empleado);
 },

 eliminarEmpleado(id) {
    return axios.delete(`${API_URL}/borrar/${id}`);
 }      

}