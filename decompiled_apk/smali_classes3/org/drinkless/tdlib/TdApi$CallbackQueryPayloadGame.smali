.class public Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadGame;
.super Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallbackQueryPayloadGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4db2ec38


# instance fields
.field public gameShortName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9330
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;-><init>()V

    .line 9331
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 9321
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;-><init>()V

    .line 9322
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryPayloadGame;->gameShortName:Ljava/lang/String;

    .line 9323
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9327
    const v0, 0x4db2ec38    # 3.7522816E8f

    return v0
.end method
