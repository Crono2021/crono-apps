.class public Lorg/drinkless/tdlib/TdApi$StartGroupCallRecording;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StartGroupCallRecording"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x68c5847b


# instance fields
.field public groupCallId:I

.field public recordVideo:Z

.field public title:Ljava/lang/String;

.field public usePortraitOrientation:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45510
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45511
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;ZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 45498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45499
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallRecording;->groupCallId:I

    .line 45500
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallRecording;->title:Ljava/lang/String;

    .line 45501
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallRecording;->recordVideo:Z

    .line 45502
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$StartGroupCallRecording;->usePortraitOrientation:Z

    .line 45503
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45507
    const v0, 0x68c5847b    # 7.462E24f

    return v0
.end method
