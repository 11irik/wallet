<template>
    <div>
        <TagDialog :visible="dialogTag" :onClose="handleCloseDialogTag"></TagDialog>

        <v-card
                max-width="500"
                class="mx-auto"
        >

            <v-list>
                <v-list-item-title class="headline mb-1">Метки</v-list-item-title>

                <TagList :tags="tags"/>

                <!--                todo also think about rules-->
                <v-list-item v-if="profile.id === defaultAccount.owner.id" @click="openDialogTag">
                    <v-list-item-icon>
                        <v-icon>mdi-plus</v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title @click="">Добавить метку</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-card>
    </div>
</template>

<script>
    import TagDialog from './dialogs/TagDialog.vue';
    import TagList from "./lists/TagList.vue";
    import {mapState} from 'vuex';

    export default {
        name: 'Tags',

        components: {
            TagDialog,
            TagList,
        },

        data() {
            return {
                dialogTag: false,
            }
        },

        computed: {
            ...mapState({
                defaultAccount: state => state.defaultAccount.defaultAccount,
                profile: state => state.profile.profile,
                tags: state => state.tags.tags,
            }),
        },
        methods: {
            openDialogTag() {
                this.dialogTag = true;
            },

            handleCloseDialogTag() {
                this.dialogTag = false;
            }
        }
    }
</script>

<style scoped>

</style>
