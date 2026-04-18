.class public Lorg/drinkless/tdlib/TdApi$GetSuggestedFileName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSuggestedFileName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7a275b7a


# instance fields
.field public directory:Ljava/lang/String;

.field public fileId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26745
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 26734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26735
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetSuggestedFileName;->fileId:I

    .line 26736
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetSuggestedFileName;->directory:Ljava/lang/String;

    .line 26737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26741
    const v0, -0x7a275b7a

    return v0
.end method
