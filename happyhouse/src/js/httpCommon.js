import axios from "axios";

export default {
	axios: axios.create({
		baseURL: "http://localhost:8089/",
		headers: {
			"Content-Type": "application/json",
		},
	}),
};
