.class public Lorg/drinkless/tdlib/TdApi$GetBotName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Text;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x65c08dd4


# instance fields
.field public botUserId:J

.field public languageCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25744
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25745
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25735
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotName;->botUserId:J

    .line 25736
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetBotName;->languageCode:Ljava/lang/String;

    .line 25737
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25741
    const v0, -0x65c08dd4

    return v0
.end method
