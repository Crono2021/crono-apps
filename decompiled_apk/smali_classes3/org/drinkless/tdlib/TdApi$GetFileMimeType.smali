.class public Lorg/drinkless/tdlib/TdApi$GetFileMimeType;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetFileMimeType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7b9ce477


# instance fields
.field public fileName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12859
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 12849
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12850
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetFileMimeType;->fileName:Ljava/lang/String;

    .line 12851
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12855
    const v0, -0x7b9ce477

    return v0
.end method
