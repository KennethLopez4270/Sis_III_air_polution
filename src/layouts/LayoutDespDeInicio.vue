<template>
    <div>
        <NavbarDespInicio />
        <router-view />
        <Footer />
    </div>
</template>

<script>
    import NavbarDespInicio from '../components/Navbar.vue';
    import Footer from '../components/Footer.vue';

    export default{
        components :{
            NavbarDespInicio,
            Footer,
        }
    }
</script>

<style scoped>
    /*Estilos para este*/
</style>