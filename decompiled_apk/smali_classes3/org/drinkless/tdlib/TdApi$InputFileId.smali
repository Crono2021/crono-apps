.class public Lorg/drinkless/tdlib/TdApi$InputFileId;
.super Lorg/drinkless/tdlib/TdApi$InputFile;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputFileId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6aa08b0d


# instance fields
.field public id:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14622
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputFile;-><init>()V

    .line 14623
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 14613
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputFile;-><init>()V

    .line 14614
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$InputFileId;->id:I

    .line 14615
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14619
    const v0, 0x6aa08b0d

    return v0
.end method
