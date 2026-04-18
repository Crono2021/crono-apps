.class public Lorg/drinkless/tdlib/TdApi$OptimizeStorage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OptimizeStorage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StorageStatistics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x32da98c7


# instance fields
.field public chatIds:[J

.field public chatLimit:I

.field public count:I

.field public excludeChatIds:[J

.field public fileTypes:[Lorg/drinkless/tdlib/TdApi$FileType;

.field public immunityDelay:I

.field public returnDeletedFileStatistics:Z

.field public size:J

.field public ttl:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 53005
    return-void
.end method

.method public constructor <init>(JIII[Lorg/drinkless/tdlib/TdApi$FileType;[J[JZI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "i11"    # I
    .param p6, "fileTypeArr"    # [Lorg/drinkless/tdlib/TdApi$FileType;
    .param p7, "jArr"    # [J
    .param p8, "jArr2"    # [J
    .param p9, "z8"    # Z
    .param p10, "i12"    # I

    .line 52987
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52988
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->size:J

    .line 52989
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->ttl:I

    .line 52990
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->count:I

    .line 52991
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->immunityDelay:I

    .line 52992
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->fileTypes:[Lorg/drinkless/tdlib/TdApi$FileType;

    .line 52993
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->chatIds:[J

    .line 52994
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->excludeChatIds:[J

    .line 52995
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->returnDeletedFileStatistics:Z

    .line 52996
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$OptimizeStorage;->chatLimit:I

    .line 52997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53001
    const v0, 0x32da98c7

    return v0
.end method
