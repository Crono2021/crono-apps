.class public Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResultPending;
.super Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SpeechRecognitionResultPending"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x61437200


# instance fields
.field public partialText:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;-><init>()V

    .line 20005
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19995
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;-><init>()V

    .line 19996
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResultPending;->partialText:Ljava/lang/String;

    .line 19997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20001
    const v0, -0x61437200

    return v0
.end method
