.class public Lorg/drinkless/tdlib/TdApi$DeleteFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6bbe9b2c


# instance fields
.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11292
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11293
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 11283
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11284
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteFile;->fileId:I

    .line 11285
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11289
    const v0, 0x6bbe9b2c

    return v0
.end method
