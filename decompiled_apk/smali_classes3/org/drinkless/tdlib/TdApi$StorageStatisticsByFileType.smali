.class public Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorageStatisticsByFileType"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2a8ef8a8


# instance fields
.field public count:I

.field public fileType:Lorg/drinkless/tdlib/TdApi$FileType;

.field public size:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40835
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FileType;JI)V
    .locals 0
    .param p1, "fileType"    # Lorg/drinkless/tdlib/TdApi$FileType;
    .param p2, "j5"    # J
    .param p4, "i9"    # I

    .line 40823
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40824
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;->fileType:Lorg/drinkless/tdlib/TdApi$FileType;

    .line 40825
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;->size:J

    .line 40826
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$StorageStatisticsByFileType;->count:I

    .line 40827
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40831
    const v0, 0x2a8ef8a8

    return v0
.end method
