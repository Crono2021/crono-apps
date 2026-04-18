.class public Lorg/drinkless/tdlib/TdApi$ChatActionUploadingPhoto;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionUploadingPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x26feeb47


# instance fields
.field public progress:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9619
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9609
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9610
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionUploadingPhoto;->progress:I

    .line 9611
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9615
    const v0, 0x26feeb47

    return v0
.end method
