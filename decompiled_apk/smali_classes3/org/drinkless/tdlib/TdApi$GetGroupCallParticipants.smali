.class public Lorg/drinkless/tdlib/TdApi$GetGroupCallParticipants;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetGroupCallParticipants"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GroupCallParticipants;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x766b3cc2


# instance fields
.field public inputGroupCall:Lorg/drinkless/tdlib/TdApi$InputGroupCall;

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26205
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputGroupCall;I)V
    .locals 0
    .param p1, "inputGroupCall"    # Lorg/drinkless/tdlib/TdApi$InputGroupCall;
    .param p2, "i9"    # I

    .line 26194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26195
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetGroupCallParticipants;->inputGroupCall:Lorg/drinkless/tdlib/TdApi$InputGroupCall;

    .line 26196
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetGroupCallParticipants;->limit:I

    .line 26197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26201
    const v0, 0x766b3cc2

    return v0
.end method
