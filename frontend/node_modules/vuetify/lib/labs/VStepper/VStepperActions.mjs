import { createVNode as _createVNode } from "vue";
// Components
import { VBtn } from "../../components/VBtn/VBtn.mjs"; // Composables
import { useLocale } from "../../composables/locale.mjs"; // Utilities
import { genericComponent, propsFactory, useRender } from "../../util/index.mjs"; // Types
export const makeVStepperActionsProps = propsFactory({
  color: String,
  disabled: {
    type: [Boolean, String],
    default: false
  },
  prevText: {
    type: String,
    default: '$vuetify.stepper.prev'
  },
  nextText: {
    type: String,
    default: '$vuetify.stepper.next'
  }
}, 'VStepperActions');
export const VStepperActions = genericComponent()({
  name: 'VStepperActions',
  props: makeVStepperActionsProps(),
  emits: {
    'click:prev': () => true,
    'click:next': () => true
  },
  setup(props, _ref) {
    let {
      emit,
      slots
    } = _ref;
    const {
      t
    } = useLocale();
    function onClickPrev() {
      emit('click:prev');
    }
    function onClickNext() {
      emit('click:next');
    }
    useRender(() => {
      return _createVNode("div", {
        "class": "v-stepper-actions"
      }, [_createVNode(VBtn, {
        "disabled": ['prev', true].includes(props.disabled),
        "text": t(props.prevText),
        "variant": "text",
        "onClick": onClickPrev
      }, null), _createVNode(VBtn, {
        "disabled": ['next', true].includes(props.disabled),
        "color": props.color,
        "text": t(props.nextText),
        "variant": "tonal",
        "onClick": onClickNext
      }, null)]);
    });
    return {};
  }
});
//# sourceMappingURL=VStepperActions.mjs.map