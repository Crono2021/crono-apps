.class public Lorg/drinkless/tdlib/TdApi$InputMessageVideoNote;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageVideoNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2a97e923


# instance fields
.field public duration:I

.field public length:I

.field public selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

.field public videoNote:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 47749
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$InputThumbnail;IILorg/drinkless/tdlib/TdApi$MessageSelfDestructType;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputThumbnail"    # Lorg/drinkless/tdlib/TdApi$InputThumbnail;
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "messageSelfDestructType"    # Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 47735
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 47736
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideoNote;->videoNote:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 47737
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideoNote;->thumbnail:Lorg/drinkless/tdlib/TdApi$InputThumbnail;

    .line 47738
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideoNote;->duration:I

    .line 47739
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideoNote;->length:I

    .line 47740
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputMessageVideoNote;->selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 47741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47745
    const v0, -0x2a97e923

    return v0
.end method
