<template>
    <v-dialog v-model="visible" persistent max-width="600px">
        <v-card>
            <v-card-title>
                <span class="headline">Список покупок</span>
            </v-card-title>
            <v-card-text>
                <v-container>
                    <v-row>
                        <v-col cols="12">
                            <v-text-field label="Описание" required v-model="itemDescription"></v-text-field>
                        </v-col>

                        <v-col cols="12">
                            <v-text-field label="Цена" required v-model="itemPrice"></v-text-field>
                        </v-col>

                        <v-col cols="12">
                            <v-select
                                    :items="tags"
                                    v-model="itemTag"
                                    item-text="name"
                                    item-value="id"
                                    label="Метка"
                                    required
                            ></v-select>
                        </v-col>

                        <v-row>
                            <v-col cols="6">
                                <v-btn @click="addItem">Добавить</v-btn>
                            </v-col>

                            <v-col cols="6">
                                <v-btn @click="onClose">Закрыть</v-btn>
                            </v-col>
                        </v-row>
                    </v-row>

                    <ItemList :items="items"/>
                </v-container>
            </v-card-text>
        </v-card>
    </v-dialog>
</template>

<script>
    import {mapState} from 'vuex';
    import ItemList from '../lists/ItemList.vue';

    export default {
        name: 'TransactionItemsDialog',

        components: {
            ItemList,
        },

        props: {
            visible: Boolean,
            onClose: Function,
            transaction: Object,
        },

        computed: {
            items() {
                return this.$store.getters.items
            },
            ...mapState({
                tags: state => state.tags.tags,
                defaultAccount: state => state.defaultAccount.defaultAccount,
            }),
        },

        data() {
            return {
                itemDescription: '',
                itemPrice: '',
                itemTag: '',
            }
        },

        methods: {
            addItem() {
                let dto = {
                    transactionId: this.transaction.id,
                    itemName: this.itemDescription,
                    itemPrice: this.itemPrice,
                    tagId: this.itemTag
                };

                this.$store.dispatch('addItemAction', dto)

                this.itemDescription = ''
                this.itemPrice = ''
                this.itemTag = ''
            },
        },
    }
</script>

<style scoped>

</style>
