local mp = require 'mp'
local assdraw = require 'mp.assdraw'

local overlay = mp.create_osd_overlay("ass-events")
local button_active = false
local skip_target_time = 0
local button_type = "" -- "intro" or "next"
local is_hovered = false

-- Button geometry (1920x1080 coordinate system)
local bw = 280
local bh = 56
local padding_right = 60
local padding_bottom = 120

local x1 = 1920 - padding_right
local x0 = x1 - bw
local y1 = 1080 - padding_bottom
local y0 = y1 - bh

local function draw_button()
    if not button_active then
        overlay:remove()
        return
    end

    local text = button_type == "intro" and "Saltar Intro" or "Siguiente Episodio"
    
    local ass = assdraw.ass_new()
    
    -- Force coordinate system to 1920x1080
    overlay.res_x = 1920
    overlay.res_y = 1080
    
    -- Colors (BGR hex)
    local bg_color = is_hovered and "&HFFFFFF&" or "&H1A1A1A&"
    local text_color = is_hovered and "&H1A1A1A&" or "&HFFFFFF&"
    local border_color = "&HFFFFFF&"
    local border_size = is_hovered and 3 or 2
    
    -- Draw Background Box
    ass:new_event()
    ass:pos(0, 0)
    ass:append(string.format("{\\bord%d\\3c%s\\1c%s\\alpha&H11&}", border_size, border_color, bg_color))
    ass:draw_start()
    ass:round_rect_cw(x0, y0, x1, y1, 6)
    ass:draw_stop()
    
    -- Draw Text
    local cx = x0 + (bw / 2)
    local cy = y0 + (bh / 2)
    
    ass:new_event()
    ass:pos(cx, cy)
    ass:append(string.format("{\\an5\\fs28\\b1\\1c%s\\bord0}", text_color))
    ass:append(text)
    
    overlay.data = ass.text
    overlay:update()
end

local function on_click(event)
    if not button_active then return end
    
    if is_hovered then
        if button_type == "intro" then
            mp.commandv("seek", skip_target_time, "absolute")
        elseif button_type == "next" then
            mp.commandv("playlist-next")
        end
        button_active = false
        draw_button()
    end
end

mp.observe_property("mouse-pos", "native", function(name, mouse)
    if not button_active then return end
    
    local was_hovered = is_hovered
    
    if mouse then
        local osd_w = mp.get_property_native("osd-width") or 1920
        local osd_h = mp.get_property_native("osd-height") or 1080
        
        -- Map to 1920x1080
        local mx = (mouse.x / osd_w) * 1920
        local my = (mouse.y / osd_h) * 1080
        
        is_hovered = (mx >= x0 and mx <= x1 and my >= y0 and my <= y1)
    else
        is_hovered = false
    end
    
    if is_hovered ~= was_hovered then
        draw_button()
    end
end)

mp.register_script_message("show_button", function(type, target)
    button_type = type
    skip_target_time = tonumber(target) or 0
    button_active = true
    draw_button()
end)

mp.register_script_message("hide_button", function()
    button_active = false
    is_hovered = false
    draw_button()
end)

mp.observe_property("osd-dimensions", "native", function()
    if button_active then draw_button() end
end)

-- Use complex bindings to ensure it doesn't conflict completely or allow event bubbling
mp.add_key_binding("MBTN_LEFT", "skip_click", on_click)