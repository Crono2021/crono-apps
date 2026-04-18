.class public Lorg/drinkless/tdlib/TdApi$UpdateSpeechRecognitionTrial;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSpeechRecognitionTrial"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb1033f


# instance fields
.field public leftCount:I

.field public maxMediaDuration:I

.field public nextResetDate:I

.field public weeklyCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46255
    return-void
.end method

.method public constructor <init>(IIII)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "i12"    # I

    .line 46242
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46243
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSpeechRecognitionTrial;->maxMediaDuration:I

    .line 46244
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateSpeechRecognitionTrial;->weeklyCount:I

    .line 46245
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateSpeechRecognitionTrial;->leftCount:I

    .line 46246
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateSpeechRecognitionTrial;->nextResetDate:I

    .line 46247
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46251
    const v0, -0xb1033f

    return v0
.end method
