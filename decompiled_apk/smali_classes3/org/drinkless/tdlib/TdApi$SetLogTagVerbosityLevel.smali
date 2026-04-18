.class public Lorg/drinkless/tdlib/TdApi$SetLogTagVerbosityLevel;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetLogTagVerbosityLevel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ce8296a


# instance fields
.field public newVerbosityLevel:I

.field public tag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31568
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31569
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 31558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31559
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetLogTagVerbosityLevel;->tag:Ljava/lang/String;

    .line 31560
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SetLogTagVerbosityLevel;->newVerbosityLevel:I

    .line 31561
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31565
    const v0, -0x7ce8296a

    return v0
.end method
