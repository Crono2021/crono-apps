.class public Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiChatTheme"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13a29822


# instance fields
.field public darkSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

.field public lightSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36895
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ThemeSettings;Lorg/drinkless/tdlib/TdApi$ThemeSettings;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "themeSettings"    # Lorg/drinkless/tdlib/TdApi$ThemeSettings;
    .param p3, "themeSettings2"    # Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 36883
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36884
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;->name:Ljava/lang/String;

    .line 36885
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;->lightSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 36886
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EmojiChatTheme;->darkSettings:Lorg/drinkless/tdlib/TdApi$ThemeSettings;

    .line 36887
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36891
    const v0, -0x13a29822

    return v0
.end method
