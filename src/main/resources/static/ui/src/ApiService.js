const ApiService = {
    StoresList: () => {
        axios
        .get("http://localhost:8080/api/store")
        .then(res => {
            console.log("stores -->", res.data.content);
            const stores = res.data.content;
            this.setState({ stores });
        })
        .catch(error => console.log("catch error: ", error));
    }
}