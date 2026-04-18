.class public Lorg/drinkless/tdlib/TdApi$InputChatThemeEmoji;
.super Lorg/drinkless/tdlib/TdApi$InputChatTheme;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputChatThemeEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x57211a3f


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14532
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatTheme;-><init>()V

    .line 14533
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14523
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputChatTheme;-><init>()V

    .line 14524
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputChatThemeEmoji;->name:Ljava/lang/String;

    .line 14525
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14529
    const v0, -0x57211a3f

    return v0
.end method
