.class public Lorg/drinkless/tdlib/TdApi$SendCallDebugInformation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendCallDebugInformation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x785b373f


# instance fields
.field public callId:I

.field public debugInformation:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30789
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 30778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30779
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SendCallDebugInformation;->callId:I

    .line 30780
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendCallDebugInformation;->debugInformation:Ljava/lang/String;

    .line 30781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30785
    const v0, 0x785b373f

    return v0
.end method
