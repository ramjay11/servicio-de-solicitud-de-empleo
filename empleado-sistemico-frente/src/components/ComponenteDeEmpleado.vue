<script>
    import { Modal } from 'bootstrap/dist/js/bootstrap.bundle.min';
    import ServicioAlEmpleado from '../servicios/ServicioAlEmpleado';

    export default {
        data() {
            return {
                empleados: [],
                formularioDeEmpleado: {
                    id: null,
                    nombreDepila: '',
                    apellidoDepila: '',
                    correoElectronico: '',
                },
                editing: false,
                modalInstance: null
            };
        },
        computed: {
            tituloModal() {
                return this.editing ? 'Editar Empleado' : 'Agregar Empleado';
            },
            botonTexto() {
                return this.editing ? 'Actualizar' : 'Agregar';
            }   
        },
        methods: {
            ostrarMmodal(empleado) {
                if (empleado) {
                    this.formularioDeEmpleado = { ...empleado };
                    this.editing = true;
                } else {
                    this.formularioDeDescanso();
                    }
                    if (!this.modalInstance) {
                        this.modalInstance = new Modal(document.getElementById('modalEmpleado'));
                    }
                this.modalInstance.show();
            },
            cargarEmpleados() {
                const accion = this.editing ? 
                'actualizarEmpleado' : 'agregarEmpleado';
                ServicioAlEmpleado[accion](this.formularioDeEmpleado)
                    .then(() => {
                        this.cargarEmpleados();
                        this.modalInstance.hide();  
                    })
            },
            cargarEmpleados() {
                ServicioAlEmpleado.conseguirEmpleados()
                .then(response => {
                    this.empleados = response.data;
                });
            },
            eliminarEmpleados(id) {
                ServicioAlEmpleado.eliminarEmpleado(id)
                .then(this.cargarEmpleados);
            },
            formularioDeDescanso() {
                this.formularioDeEmpleado = {
                    id: null,
                    nombreDepila: '',
                    apellidoDepila: '',
                    correoElectronico: ''
                };
                this.editing = false;
            }
        },
            mounted() {
            this.cargarEmpleados();
        }
    }
</script>
<template>
    <div class="container mt-3">
        <button class="btn btn-primary">Agregar empleado</button>
        <table class="table table-striped mt-3">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo Electrónico</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="empleado in empleados" :key="empleado.id">
                    <td>{{ empleado.id }}</td>
                    <td>{{ empleado.nombreDepila }}</td>
                    <td>{{ empleado.apellidoDepila }}</td>
                    <td>{{ empleado.correoElectronico }}</td>   
                    <td>
                        <button class="btn btn-warning" @click="ostrarMmodal(empleado)">Editar</button> <span> </span>
                        <button class="btn btn-danger" @click="eliminarEmpleados(empleado.id)">Eliminar</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <div class="modal fade" id="modalEmpleado" tabindex="-1" aria-labelledby="modalEmpleadoLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">{{ tituloModal }}</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form @submit.prevent="cargarEmpleados">
                            <div class="mb-3">
                                <label for="nombreDepila" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="nombreDepila" v-model="formularioDeEmpleado.nombreDepila" required>    
                            </div>    
                            <div class="mb-3">  
                                <label for="apellidoDepila" class="form-label">Apellido</label>
                                <input type="text" class="form-control" id="apellidoDepila" v-model="formularioDeEmpleado.apellidoDepila" required>
                            </div>                                  
                            <div class="mb-3">                                                      
                                <label for="correoElectronico" class="form-label">Correo Electrónico</label>
                                <input type="email" class="form-control" id="correoElectronico" v-model="formularioDeEmpleado.correoElectronico" required>
                            </div>
                            <button type="submit" class="btn btn-primary">{{ botonTexto }}</button> 
                        </form>
                    </div>   
                </div>
            </div>
        </div>                   
    </div>
</template>