import Vue from 'vue';
import VueRouter from 'vue-router';
import App from './App.vue';
import SongsList from './components/Songlist.vue'; // Import your song list component

Vue.use(VueRouter);

const routes = [
    {
        path: '/kokos',
        component: SongsList
    },
    // Define other routes here
];

const router = new VueRouter({
    mode: 'history',
    routes
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');
