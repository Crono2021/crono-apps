.class public Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPersonalDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x63f47baa


# instance fields
.field public files:[Lorg/drinkless/tdlib/TdApi$InputFile;

.field public translation:[Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27424
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27425
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$InputFile;[Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "inputFileArr"    # [Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "inputFileArr2"    # [Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 27414
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27415
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;->files:[Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 27416
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;->translation:[Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 27417
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27421
    const v0, 0x63f47baa

    return v0
.end method
