.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVideoNote;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeVideoNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x308f249f


# instance fields
.field public videoNote:Lorg/drinkless/tdlib/TdApi$VideoNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16045
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$VideoNote;)V
    .locals 0
    .param p1, "videoNote"    # Lorg/drinkless/tdlib/TdApi$VideoNote;

    .line 16035
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 16036
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeVideoNote;->videoNote:Lorg/drinkless/tdlib/TdApi$VideoNote;

    .line 16037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16041
    const v0, -0x308f249f

    return v0
.end method
