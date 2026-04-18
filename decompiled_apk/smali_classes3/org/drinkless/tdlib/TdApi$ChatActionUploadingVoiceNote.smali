.class public Lorg/drinkless/tdlib/TdApi$ChatActionUploadingVoiceNote;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionUploadingVoiceNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x24937592


# instance fields
.field public progress:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9672
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9673
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9663
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9664
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionUploadingVoiceNote;->progress:I

    .line 9665
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9669
    const v0, -0x24937592

    return v0
.end method
