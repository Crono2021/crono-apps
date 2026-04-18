.class public Lorg/drinkless/tdlib/TdApi$SetStickerKeywords;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStickerKeywords"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x82ddd8d


# instance fields
.field public keywords:[Ljava/lang/String;

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31928
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31929
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;[Ljava/lang/String;)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 31918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31919
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetStickerKeywords;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 31920
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetStickerKeywords;->keywords:[Ljava/lang/String;

    .line 31921
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31925
    const v0, 0x82ddd8d

    return v0
.end method
