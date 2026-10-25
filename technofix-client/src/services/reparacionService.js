import axios from 'axios';

const API_REP = "http://localhost:8080/api/reparaciones";

export const reparacion_service = {
    getAll: async ()=>{
        const response = await axios.get(API_REP)
        return response.data;
    } 
}