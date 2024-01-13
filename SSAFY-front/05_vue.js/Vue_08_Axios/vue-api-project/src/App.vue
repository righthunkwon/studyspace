<template>
    <div>
        <header>
            <nav>
                <RouterLink to="/">Home</RouterLink>
                <RouterLink to="/youtube">Youtube</RouterLink>
            </nav>
        </header>

        <RouterView/>
    </div>
</template>

<script setup>
import {RouterLink, RouterView} from 'vue-router'
</script>

<style  scoped>

</style>