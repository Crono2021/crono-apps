.class public Lorg/drinkless/tdlib/TdApi$BotCommandScopeAllChatAdministrators;
.super Lorg/drinkless/tdlib/TdApi$BotCommandScope;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BotCommandScopeAllChatAdministrators"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x771c1551


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 280
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BotCommandScope;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 285
    const v0, 0x771c1551

    return v0
.end method
