console.log("ABX")
let app = new Vue({
    el: '#personaVue',
    data: {
        url: '/allPersonas',
        personas: {id: '', paterno: '', materno: '', nombres: ''},
        test: 'Probando vue'
    }, created: function () {
//        this.persona = {};
    }, mounted() {
        this.allPersonas();

    }, methods: {

        allPersonas() {
            console.log("PERSONAS JSON")
            let $vue = this;
            axios.get($vue.url)
                    .then(function (response) {
                        console.log("correcto")
                        console.log(response.data.success)
                        if (response.data.success) {
                            $vue.personas = response.data.data;
                            console.dir($vue.personas)
                        }
                    })
                    .catch(function (error) {
                        console.log("ERROR");
                        console.log(error);
                    });


        }
    }
})