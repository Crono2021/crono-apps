.class public Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMapThumbnailFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$File;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x9196866


# instance fields
.field public chatId:J

.field public height:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public scale:I

.field public width:I

.field public zoom:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49899
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;IIIIJ)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "i12"    # I
    .param p6, "j5"    # J

    .line 49884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49885
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 49886
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;->zoom:I

    .line 49887
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;->width:I

    .line 49888
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;->height:I

    .line 49889
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;->scale:I

    .line 49890
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$GetMapThumbnailFile;->chatId:J

    .line 49891
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49895
    const v0, -0x9196866

    return v0
.end method
