.class public Lorg/drinkless/tdlib/TdApi$MessageChatSetTheme;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatSetTheme"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x492a6097


# instance fields
.field public theme:Lorg/drinkless/tdlib/TdApi$ChatTheme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16332
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16333
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatTheme;)V
    .locals 0
    .param p1, "chatTheme"    # Lorg/drinkless/tdlib/TdApi$ChatTheme;

    .line 16323
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16324
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatSetTheme;->theme:Lorg/drinkless/tdlib/TdApi$ChatTheme;

    .line 16325
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16329
    const v0, 0x492a6097

    return v0
.end method
