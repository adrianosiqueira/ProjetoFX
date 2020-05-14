#!/usr/bin/env bash

# Verifica se o projeto foi compilado
if [[ ! -d "out/production/ProjetoFX" ]]; then
  echo "[ E ] - O projeto não foi compilado ainda."
  exit 1
fi

# Poupa tempo (sera desfeito quando o script finalizar)
export JavaFX_14_JMODS="/usr/lib/jvm/javafx-jmods-14.0.1/"

# Limpa a pasta de saída e constrói dentro dela
_BUILD="build"
rm -rf "$_BUILD"
jlink14 --module-path "out/production/ProjetoFX"":""$JavaFX_14_JMODS" --add-modules ProjetoFX --output "$_BUILD"

# Entra na pasta construída
_BIN="$_BUILD""/bin"
cd "$_BIN" || exit 1

# Criar lançador para Linux
_LINUX="launcher.sh"
echo "#!/usr/bin/env bash" > "$_LINUX"
echo "" >> "$_LINUX"
echo "./java --enable-preview --module ProjetoFX/pacote.Programa" >> "$_LINUX"
echo "" >> "$_LINUX"
chmod 755 "$_LINUX"

# TODO Criar lançador para windows

clear
exit 0
