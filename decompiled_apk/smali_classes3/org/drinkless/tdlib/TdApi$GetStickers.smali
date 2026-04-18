.class public Lorg/drinkless/tdlib/TdApi$GetStickers;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStickers"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Stickers;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x45069343


# instance fields
.field public chatId:J

.field public limit:I

.field public query:Ljava/lang/String;

.field public stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43566
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43567
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StickerType;Ljava/lang/String;IJ)V
    .locals 0
    .param p1, "stickerType"    # Lorg/drinkless/tdlib/TdApi$StickerType;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I
    .param p4, "j5"    # J

    .line 43554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43555
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetStickers;->stickerType:Lorg/drinkless/tdlib/TdApi$StickerType;

    .line 43556
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetStickers;->query:Ljava/lang/String;

    .line 43557
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetStickers;->limit:I

    .line 43558
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$GetStickers;->chatId:J

    .line 43559
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43563
    const v0, 0x45069343

    return v0
.end method
