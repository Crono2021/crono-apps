.class public Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResultError;
.super Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SpeechRecognitionResultError"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9d243fc


# instance fields
.field public error:Lorg/drinkless/tdlib/TdApi$Error;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19986
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;-><init>()V

    .line 19987
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Error;)V
    .locals 0
    .param p1, "error"    # Lorg/drinkless/tdlib/TdApi$Error;

    .line 19977
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;-><init>()V

    .line 19978
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResultError;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 19979
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19983
    const v0, 0x9d243fc

    return v0
.end method
