.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeAudio;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x75e407d2


# instance fields
.field public audio:Lorg/drinkless/tdlib/TdApi$Audio;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15865
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Audio;)V
    .locals 0
    .param p1, "audio"    # Lorg/drinkless/tdlib/TdApi$Audio;

    .line 15855
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15856
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeAudio;->audio:Lorg/drinkless/tdlib/TdApi$Audio;

    .line 15857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15861
    const v0, 0x75e407d2

    return v0
.end method
