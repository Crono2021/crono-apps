.class public Lorg/drinkless/tdlib/TdApi$DecryptGroupCallData;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DecryptGroupCallData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Data;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6a333de4


# instance fields
.field public data:[B

.field public dataChannel:Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;

.field public groupCallId:I

.field public participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42990
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42991
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;[B)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "groupCallDataChannel"    # Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;
    .param p4, "bArr"    # [B

    .line 42978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42979
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DecryptGroupCallData;->groupCallId:I

    .line 42980
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DecryptGroupCallData;->participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 42981
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DecryptGroupCallData;->dataChannel:Lorg/drinkless/tdlib/TdApi$GroupCallDataChannel;

    .line 42982
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$DecryptGroupCallData;->data:[B

    .line 42983
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42987
    const v0, 0x6a333de4

    return v0
.end method
