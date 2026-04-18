.class public Lorg/drinkless/tdlib/TdApi$ChatActionUploadingDocument;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionUploadingDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xa01b64a


# instance fields
.field public progress:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9600
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9601
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9591
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9592
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionUploadingDocument;->progress:I

    .line 9593
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9597
    const v0, 0xa01b64a

    return v0
.end method
